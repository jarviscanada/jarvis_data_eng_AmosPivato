#! /bin/bash

psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5

if [ $# -ne 5]; then
  echo 'Insuficient number of arguments for given command'
  exit 1
fi

lscpu_out=`lscpu`
hostname=$(hostname -f)

timestamp=$(vmstat -t | awk 'FNR == 3 {print $18, $19}')

#Retrieve hardware specification 
cpu_number=$(echo "$lscpu_out" | egrep "^CPU\(s\):" | awk '{print $2}' | xargs)
cpu_architecture=$(echo "$lscpu_out" | egrep "^Architecture:" | awk '{print $2}' | xargs)
cpu_model=$(echo "$lscpu_out" | egrep "^Model name:" | awk '{$1=$2=$3=""; print $0}' | xargs)
cpu_mhz=$(echo "$lscpu_out" | egrep "^CPU\sMHz:" | awk '{print $3}' | xargs)
L2_cache=$(echo "$lscpu_out" | egrep "^L2\scache:" | awk '{print $3}' | xargs)
total_mem=$(grep MemTotal /proc/meminfo | awk '{print $2}')

insert_stmt="INSERT INTO host_usage (hostname, cpu_number, cpu_architecture, cpu_model, cpu_mhz, L2_cache, total_mem, timestamp) VALUES($hostname, $cpu_number, $cpu_architecture, $cput_model, $cpu_mhz, $L2_cache, $total_mem, $timestamp);"

export PGPASSWORD=$psql_password 

psql -h $psql_host -p $psql_port -d $db_name -U $psql_user -c "$insert_stmt"
exit $?
