import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DataTableModule, SharedModule } from 'primeng/primeng';



import { EntitiesRoutingModule } from './entities-routing.module';
import { EmployeeComponent } from './employee/employee.component';
import { DepartmentComponent } from './department/department.component';
import { CompanyComponent } from './company/company.component';
import { EmployeeService } from "./employee/employee.service";
import { DepartmentService } from "./department/department.service";
import { CompanyService } from "./company/company.service";

@NgModule({
  imports: [
    CommonModule,
    EntitiesRoutingModule,
    DataTableModule,
    SharedModule,
  ],
  declarations: [EmployeeComponent, DepartmentComponent, CompanyComponent],
  providers: [EmployeeService, DepartmentService, CompanyService]

})
export class EntitiesModule { }
