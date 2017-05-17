package com.wspfeiffer.kotlin.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Department entity
 */

@Entity
@Table(name = "department")
@JsonIgnoreProperties("handler", "hibernateLazyInitializer")
open class Department (
        @Id
        @GeneratedValue(generator="sequenceGenerator", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "sequenceGenerator", sequenceName = "hibernate_sequence")
        var id: Long = 0,

        @NotNull
        @Size(min = 2, max = 20)
        @Column(name = "dept_code", length = 20, nullable = false)
        var deptCode: String = "",

        @NotNull
        @Size(min = 3, max = 30)
        @Column(name = "dept_name", length = 30, nullable = false)
        var deptName: String = "",

        @ManyToOne
        var company: Company? = null

) {


}
