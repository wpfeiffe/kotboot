import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';
import { DepartmentComponent } from './department/department.component';
import { CompanyComponent } from './company/company.component';

const routes: Routes = [
  {
    path: "employee",
    component: EmployeeComponent
  },
  {
    path: "department",
    component: DepartmentComponent
  },
  {
    path: "company",
    component: CompanyComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EntitiesRoutingModule { }
