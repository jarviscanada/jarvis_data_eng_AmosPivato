INSERT INTO host_info (hostname, cpu_number, cpu_architecture, cpu_model, cpu_mhz, L2_cache, total_mem, "timestamp")
VALUES
    ('test1',1 ,'test1' ,'test1' , 5.0, 45, 2048, '2019-05-29 15:00:00.000'),
    ('test2',1 ,'test1' ,'test1' , 5.0, 45, 1568, '2019-05-29 15:00:00.000'),
    ('test3',1 ,'test1', 'test1' , 5.0, 45, 1024, '2019-05-29 15:00:00.000'),
    ('test4',1 ,'test1' ,'test1' , 5.0, 45, 2088, '2019-05-29 15:00:00.000'),
    ('test5',1 ,'test1' ,'test1' , 5.0, 45, 1024, '2019-05-29 15:00:00.000'),
    ('test6',1 ,'test1' ,'test1' , 5.0, 45, 5000, '2019-05-29 15:00:00.000');

INSERT INTO host_usage ("timestamp", host_id, memory_free, cpu_idle, cpu_kernel, disk_io, disk_available)
 VALUES
     ('2019-05-29 15:00:00.000', 3, 300000, 90, 4, 2, 3),
     ('2019-05-29 15:01:00.000', 4, 200000, 90, 4, 2, 3),
     ('2019-05-29 15:02:00.000', 3, 100000, 90, 4, 2, 3),
     ('2019-05-29 15:03:00.000', 4, 600000, 90, 4, 2, 3),
     ('2019-05-29 15:04:00.000', 3, 500000, 90, 4, 2, 3);