package orther.lambdaDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] array = {1,3,5,2,4};

        Arrays.stream(array).filter((x)->x%2==1).map((x)->x*x).forEach(System.out::println);
        Arrays.stream(array).filter((x)->x%2==1).map((x)->x*x).reduce(Integer::sum).ifPresent(System.out::println);


        List<Message> messages = new ArrayList<>();
        messages.add(new Message("aglover", "foo", 56854));
        messages.add(new Message("aglover", "foo", 85));
        messages.add(new Message("aglover", "bar", 9999));
        messages.add(new Message("rsmith", "foo", 4564));

        //我希望找到Message当中所有延迟周期超过3000秒的条目并计算它们的总计延迟时⻓长。

        long totWaitTime = messages.stream().filter(m -> m.delay > 3000).mapToLong(m -> m.delay).sum();
        System.out.println(totWaitTime);
    }


    private static class Message {
        String sender;
        String content;
        int delay;
        public Message(String sender, String content, int delay) {
            this.sender = sender;
            this.content = content;
            this.delay = delay;
        }

    }

}
