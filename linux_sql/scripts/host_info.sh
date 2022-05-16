#! /bin/bash

#command line arguments 
psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5

#check if there are the right amount of arguments
if [ $# -ne 5 ]; then
  echo 'Insuficient number of arguments for given command'
  exit 1
fi

#set up the varibles for the insert and parse the host machines specs
lscpu_out=`lscpu`
hostname=$(hostname -f)

timestamp=$(vmstat -t | awk 'FNR == 3 {print $18, $19}')
 
cpu_number=$(echo "$lscpu_out" | egrep "^CPU\(s\):" | awk '{print $2}' | xargs)
cpu_architecture=$(echo "$lscpu_out" | egrep "^Architecture:" | awk '{print $2}' | xargs)
cpu_model=$(echo "$lscpu_out" | egrep "^Model name:" | awk '{$1=$2=$3=""; print $0}' | xargs)
cpu_mhz=$(echo "$lscpu_out" | egrep "^CPU\sMHz:" | awk '{print $3}' | xargs)
L2_cache=$(echo "$lscpu_out" | egrep "^L2\scache:" | awk '{print $3}' | grep -o -E '[0-9]+' | xargs)
total_mem=$(grep MemTotal /proc/meminfo | awk '{print $2}')

#sql insert statement to be used when connecting to psql database and store host machine specs
insert_stmt="INSERT INTO host_info (hostname, cpu_number, cpu_architecture, cpu_model, cpu_mhz, L2_cache, total_mem, timestamp) VALUES('$hostname', '$cpu_number', '$cpu_architecture', '$cpu_model', '$cpu_mhz', '$L2_cache', '$total_mem', '$timestamp');"

export PGPASSWORD=$psql_password 

#psql command to connect and run insert statment
psql -h $psql_host -p $psql_port -d $db_name -U $psql_user -c "$insert_stmt"
exit $?
