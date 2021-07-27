package data.services

import data.boundairds.IEmployeesService
import data.entity.Employee
import kotlinx.coroutines.delay

class StubEmployeesService : IEmployeesService {
    override suspend fun getEmployes(): List<Employee> {
        delay(3000)
        return listOf(Employee("Jon","Jackson","Zeric","12.12.2008"),
            Employee("Ann","Smith","Ann_Sm","12.12.2009"),
            Employee("Jack","Adams","J_A","12.12.2010"),
            Employee("Joan","Azimov","Joan_Az","12.12.2011"),
            Employee("Martin","Razumovski","Mar_Raz","12.12.2012"),
            Employee("Felix","Pitt","Fel_Pit","12.12.2013"))
    }
}