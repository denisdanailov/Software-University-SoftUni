CREATE TABLE IF NOT EXISTS `deleted_employees` (
  `employee_id` int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `job_title` varchar(50) NOT NULL,
  `department_id` int(10) NOT NULL,
  `salary` decimal(19,4) NOT NULL);
  
DELIMITER &&
CREATE TRIGGER `employees_AFTER_DELETE` AFTER DELETE ON `employees` FOR EACH ROW BEGIN
INSERT INTO deleted_employees (first_name,last_name,middle_name,job_title,department_id,salary)
VALUES (OLD.first_name, OLD.last_name, OLD.middle_name, OLD.job_title, OLD.department_id, OLD.salary);
END
&&
