package data.repository

import data.boundairds.IEmployeesService
import data.entity.Employee
import data.entity.fromEmployeeToEmployeeDTO
import data.entity.fromEmployeeToEmployeeDTO
import domain.boundaries.IEmployeesRepository
import domain.entity.EmployeeDTO

class ImpEmployeesRepository(private val employeesService:IEmployeesService): IEmployeesRepository {
    override suspend fun getEmployes(): List<EmployeeDTO> {
        val listOfEmployee = employeesService.getEmployes()
        return listOfEmployee.map { employee-> fromEmployeeToEmployeeDTO(employee) }
    }
}