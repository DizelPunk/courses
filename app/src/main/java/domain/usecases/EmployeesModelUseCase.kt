package domain.usecases

import domain.boundaries.IEmployeesRepository
import domain.entity.EmployeeDTO

class EmployeesModelUseCase(private val emplyessRepository: IEmployeesRepository) {
    suspend fun getEmployees(): List<EmployeeDTO> {
        return emplyessRepository.getEmployes()
    }
}