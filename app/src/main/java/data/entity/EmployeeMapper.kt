package data.entity

import domain.entity.EmployeeDTO

fun fromEmployee(src: Employee) = EmployeeDTO(
    src.getFirstName(),
    src.getLastName(),
    src.getUserName(),
    src.getEmployeeData()
)