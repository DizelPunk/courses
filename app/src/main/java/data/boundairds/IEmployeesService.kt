package data.boundairds

import data.entity.Employee

interface IEmployeesService {
    suspend fun getEmployes():List<Employee>
}