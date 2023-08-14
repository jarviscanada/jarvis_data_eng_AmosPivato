CREATE FUNCTION round5(ts timestamp) RETURNS timestamp AS 
$$  
BEGIN
    RETURN date_trunc('hour', ts) + date_part('minute', ts):: int / 5 * interval '5 min';
END;
$$
    LANGUAGE PLPGSQL;

SELECT 
  cpu_number, 
  id as host_id, 
  total_mem
FROM host_info
ORDER BY cpu_number, total_mem DESC;

SELECT 
  host_id, 
  host_info.hostname, 
  round5(host_usage.timestamp), 
  CAST(AVG(((host_info.total_mem/1024.0)-memory_free)/(host_info.total_mem/1024.0)*100) AS INT) as avg_used_mem_percentage
FROM host_usage
INNER JOIN host_info ON host_usage.host_id = host_info.id
GROUP BY round5(host_usage.timestamp), host_id, host_info.hostname
ORDER BY host_id, avg_used_mem_percentage DESC;

SELECT 
  host_id, 
  round5(timestamp) as ts, 
  COUNT(*) as num_data_points
FROM host_usage
GROUP BY host_id, ts
HAVING COUNT(*) < 3
ORDER BY host_id;
