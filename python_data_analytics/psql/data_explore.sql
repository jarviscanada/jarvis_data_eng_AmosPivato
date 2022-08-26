-- Show table schema 
\d+ retail;

-- Show first 10 rows
SELECT * FROM retail limit 10;

-- Check # of records
SELECT COUNT(invoice_no) as count from retail;

-- number of clients (e.g. unique client ID)
SELECT COUNT(DISTINCT customer_id) as count from retail;

-- invoice date range (e.g. max/mind dates)
SELECT MAX(invoice_date) as max,  MIN(invoice_date) as min  from retail;

-- number of SKU/merchants (e.g. unique stock code)
SELECT COUNT(DISTINCT stock_code) as count from retail;

-- calculate average invoice amount excluding invoices with a negative amount (e.g. orders have negative amount)
SELECT AVG(s.amount) as avg FROM (SELECT SUM(unit_price * quantity) as amount FROM retail group by invoice_no) AS s where s.amount > 0;

-- calculate total revenue (e.g. sum of unit_proce * quantity)
SELECT SUM(quantity * unit_price) as sum FROM retail;

-- calculate total revenue by YYYMM
SELECT concat(EXTRACT(YEAR from invoice_date), EXTRACT(MONTH from invoice_date)) as yyymm, SUM(unit_price * quantity) as sum from retail group by concat(EXTRACT(YEAR from invoice_date), EXTRACT(MONTH from invoice_date)) order by concat(EXTRACT(YEAR from invoice_date), EXTRACT(MONTH from invoice_date));
