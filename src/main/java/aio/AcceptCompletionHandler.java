/*
 * Copyright 2013-2018 Lilinfeng.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author lilinfeng
 * @version 1.0
 * <p>
 * 异步回调的接口方法
 * @date 2014年2月16日
 */
public class AcceptCompletionHandler implements
        CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {

    @Override
    public void completed(AsynchronousSocketChannel result,
                          AsyncTimeServerHandler attachment) {
        // 再次调用 accept 方法 的原因是 ：调用 AsynchronousSocketChannel 的 accept 方法后，
        // 如果有新的客户端连接接入，系统将回调我们传入的 CompletionHandler 实例的 completed 方法，表示新的客户端接入成功
        // 一个 AsynchronousSocketChannel 可以接入成千上万个客户端，所以需要继续调用 accept 方法
        // 最终形成一个循环
        attachment.asynchronousServerSocketChannel.accept(attachment, this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 异步读操作
        // ByteBuffer dst    The buffer into which bytes are to be transferred
        // A attachment    The object to attach to the I/O operation; can be {@code null} 异步 Channel 携带的附件，通知回调的时候作为入参使用
        // CompletionHandler<Integer,? super A> handler    The handler for consuming the result
        result.read(buffer, buffer, new ReadCompletionHandler(result));
    }

    @Override
    public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
        exc.printStackTrace();
        attachment.latch.countDown();
    }

}
