/* Consulta */

SELECT
  empregado.id,
  empregado.name as nome ,
  round(avg(salario.value), 2) as media_salarial
FROM
  employee empregado
  INNER JOIN salary salario on salario.employee_id = empregado.id
WHERE
  salario.payment_date >= current_date - interval '3 months'
GROUP BY
  empregado.id,
  empregado.name
ORDER BY
  media_salarial desc
LIMIT
  3;