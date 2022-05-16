SELECT cpu_number, host_id, total_mem
FROM host_info
ORDER BY cpu_number, total_mem;

SELECT host_id, host_name, "timestamp", round5("timestamp"), memory_free/(host_info.total_mem/1024)/count() as avg_used_mem_percentage
FROM host_usage
inner join host_info where host_id = id
GROUP BY round5("timestamp"), host_id
ORDER BY host_id, avg_used_mem_percentage;

SELECT

CREATE FUNCTION round5(ts timstamp) RETURNS timestamp AS $$
BEGIN
    RETURN date_trunc('hour', ts) + date_part('minute', ts):: int / 5 * interval '5 min';
END;
$$
    LANGUAGE PLPGSQL;



