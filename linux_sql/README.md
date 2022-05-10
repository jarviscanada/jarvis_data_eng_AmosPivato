# Introduction
This Linux cluster monitoring agent allows for easy LCA node cluster hardware recording and resource monitoring, through the use of of RDBMS to store all the nodes date which is then used to create reports for future recource planning.

# Quick Start
Use markdown code block for your quick-start commands
- Start a psql instance using psql_docker.sh
- Create tables using ddl.sql
- Insert hardware specs data into the DB using host_info.sh
- Insert hardware usage data into the DB using host_usage.sh
- Crontab setup

# Implemenation
tbd

## Tech Stack
tbd

## Architecture

![Architecture graph](/assets/Architecture.drawio.png)
Draw a cluster diagram with three Linux hosts, a DB, and agents (use draw.io website). Image must be saved to the `assets` directory.

## Scripts
Shell script description and usage (use markdown code block for script usage)
- psql_docker.sh
- host_info.sh
- host_usage.sh
- crontab
- queries.sql (describe what business problem you are trying to resolve)

## Database Modeling
Describe the schema of each table using markdown table syntax (do not put any sql code) TBD
- `host_info`
- `host_usage`

# Test
How did you test your bash scripts and SQL queries? What was the result?
TBD

# Deployment
How did you deploy your app? (e.g. Github, crontab, docker)
TBD

# Improvements
Write at least three things you want to improve 
e.g. 
- handle hardware update 
- blah
- blah
