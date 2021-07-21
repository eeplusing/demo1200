BEGIN
    declare rowcount int default 0;

    start transaction;

    update t_money set money=money -1000 where id = 1 and money-1000 >= 0;

    select row_count() into rowcount;

    update t_money set money=money+1000 where id = 2;

    if rowcount = 0 then
        rollback;
    else
        commit;
    end if;

END