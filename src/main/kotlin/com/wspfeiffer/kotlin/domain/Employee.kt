package com.wspfeiffer.kotlin.domain

import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Employee entity
 */
@Entity
@Table(name="employee")
open class Employee (
        @Id
        @GeneratedValue(generator="sequenceGenerator", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "sequenceGenerator", sequenceName = "hibernate_sequence")
        var id: Long = 0,

        @NotNull
        @Size(min = 2, max = 40)
        @Column(name = "first_name", length = 40, nullable = false)
        var firstName: String = "",

        @NotNull
        @Size(min = 2, max = 40)
        @Column(name = "last_name", length = 40, nullable = false)
        var lastName: String = "",

        @NotNull
        @Column(name = "active", nullable = false)
        var active: Boolean = false,

        @NotNull
        @Column(name = "start_date", nullable = false)
        var startDate: LocalDate = LocalDate.now(),

        @NotNull
        @Size(min = 8, max = 40)
        @Column(name = "title", length = 40, nullable = false)
        var title: String = "",

        @ManyToOne
        var department: Department? = null
) {

}
