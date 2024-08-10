package ru.belonogov.taskservicekotlin.domain.entity

import jakarta.persistence.*

@Entity
class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_seq")
    @SequenceGenerator(name = "task_id_seq", allocationSize = 1)
    var id: Long,
    var name: String,
    var description: String,
    var rating: String,
    var taskStatus: TaskStatus,
    @ManyToMany(mappedBy = "tasks", cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    var employees: MutableSet<Employee>
) {
    fun addEmployee(employee: Employee) {
        this.employees.add(employee)
        employee.tasks.add(this)
    }

    fun removeEmployee(employee: Employee) {
        this.employees.remove(employee)
        employee.tasks.remove(this)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Task

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
