#! /bin/bash

#command line arguments
psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5

#check if there are the appropriate amount of commandline argumetns
if [ $# -ne 5 ]; then
  echo 'invalide number of arguments for given command'
  exit 1
fi

#set up host machine usage variables and parsing them
vmstat_mb=$(vmstat --unit M)
hostname=$(hostname -f)

timestamp=$(vmstat -t | awk 'FNR ==3 {print $18, $19}')

memory_free=$(echo "$vmstat_mb" | awk '{print $4}'| tail -n1 | xargs)
cpu_idle=$(echo "$vmstat_mb" | awk '{print $15}' | tail -n1 | xargs)
cpu_kernel=$(echo "$vmstat_mb" | awk '{print $14}' | tail -n1 | xargs)
disk_io=$(vmstat -d | awk 'FNR == 3 {print $10}')
disk_available=$(df -m / | awk 'FNR == 2 {print $4}')

#subquery to obtain host id from the host_info table
host_id="(SELECT id FROM host_info WHERE hostname = '$hostname')";

#insert query to store host usage parsed data into database
insert_stmt="INSERT INTO host_usage(timestamp, host_id, memory_free, cpu_idle, cpu_kernel, disk_io, disk_available) VALUES('$timestamp', $host_id, '$memory_free', '$cpu_idle', '$cpu_kernel', '$disk_io', '$disk_available');"

export PGPASSWORD=$psql_password 

#psql command to connect and run insert query and send data into the database
psql -h $psql_host -p $psql_port -d $db_name -U $psql_user -c "$insert_stmt"
exit $?
