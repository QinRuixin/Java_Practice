select xx, max(a)
from T
where b>3
group by xx
having max(a)>??
order by xx

select 后的字段一定要出现在 group by 中，除非是函数

1. start
2. from
3. where
4. group by 分组
5. having 过滤掉不符合条件的分组
6. select 选出字段
7. order by 排序
8. end