package domain.boundaries

import data.entity.Employee
import domain.entity.EmployeeDTO

interface IEmployeesRepository {
    suspend fun getEmployes():List<EmployeeDTO>
}