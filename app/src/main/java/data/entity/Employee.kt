package data.entity

class Employee(
    private val firstName: String,
    private val lastName: String,
    private val userName: String,
    private val employeeDate: String
) {

    fun getFirstName() = this.firstName
    fun getLastName() = this.lastName
    fun getUserName() = this.userName
    fun getEmployeeData() = this.employeeDate
}