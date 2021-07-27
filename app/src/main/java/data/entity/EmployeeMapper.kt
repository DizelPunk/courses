package data.entity

import domain.entity.EmployeeDTO

fun fromEmployeeToEmployeeDTO(src: Employee) = EmployeeDTO(
    src.getFirstName(),
    src.getLastName(),
    src.getUserName(),
    src.getEmployeeData()
)