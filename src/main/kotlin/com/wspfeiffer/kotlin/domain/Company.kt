package com.wspfeiffer.kotlin.domain

import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Company entity
 */
@Entity
@Table(name = "company")
open class Company(
        @Id
        @GeneratedValue(generator="sequenceGenerator", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "sequenceGenerator", sequenceName = "hibernate_sequence")
        var id: Long = 0,

        @NotNull
        @Size(min = 5, max = 60)
        @Column(name = "company_name", length = 60, nullable = false)
        var companyName: String = ""
        ) {

}
