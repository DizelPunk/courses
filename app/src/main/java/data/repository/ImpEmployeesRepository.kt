package data.repository

import data.boundairds.IEmployeesService
import data.entity.Employee
import domain.boundaries.IEmployeesRepository
import domain.entity.EmployeeDTO

class ImpEmployeesRepository(private val employeesService:IEmployeesService): IEmployeesRepository {
    override suspend fun getEmployes(): List<EmployeeDTO> {
        val listOfEmployee = employeesService.getEmployes()
        val listOfEmployeeDTO:MutableList<EmployeeDTO> = mutableListOf()
        listOfEmployee.forEach {
            listOfEmployeeDTO.add(EmployeeDTO.fromEmployee(it))
        }
        return listOfEmployeeDTO
    }
}