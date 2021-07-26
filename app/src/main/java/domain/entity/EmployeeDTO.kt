package domain.entity

import data.entity.Employee

class EmployeeDTO(
    private val firstName: String,
    private val lastName: String,
    private val userName: String,
    private val employeeDate: String
) {
    fun getFirstName() = this.firstName
    fun getLastName() = this.lastName
    fun getUserName() = this.userName
    fun getEmployeeDate() = this.employeeDate

    companion object {
        fun fromEmployee(src: Employee) = EmployeeDTO(
            src.getFirstName(),
            src.getLastName(),
            src.getUserName(),
            src.getEmployeeData()
        )
    }

}