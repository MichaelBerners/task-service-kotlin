package ru.belonogov.taskservicekotlin.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinColumns
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator

@Entity
class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employees_id_seq")
    @SequenceGenerator(name = "employees_id_seq", allocationSize = 1)
    var id: Long? = null,
    var firstName:String? = null,
    var lastName: String? = null,
    var rating: Int = 5,
    @ManyToOne
    @JoinColumn(name = "company_id")
    var company: Company,
    @ManyToMany
    @JoinTable(
        name = "tasks_employee",
        joinColumns = [JoinColumn(name = "employee_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "task_id", referencedColumnName = "id")]
    )
    var tasks: MutableSet<Task> = mutableSetOf()
) {

    fun addTask(task: Task) {
        this.tasks.add(task)
        task.employees.add(this)
    }

    fun removeTask(task: Task) {
        this.tasks.remove(task)
        task.employees.remove(this)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Employee

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }


}
