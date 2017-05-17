import { Component, OnInit } from '@angular/core';
import {Company} from "./company.model";
import {CompanyService} from "./company.service";

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  companies: Company[] = [];
  errorMessage: string = "";
  selectionMessage: string = "";

  constructor(private companyService: CompanyService) { }

  ngOnInit() {
    this.getCompanys();
  }

  getCompanys() {
    this.companyService.getCompanies()
      .subscribe(
        companies => this.companies = companies,
        error => this.errorMessage = error);
  }

  onRowSelect(event){
    console.log(event);
    this.selectionMessage = `You selected company "${event.data.companyName}"`;
  }

  onRowUnselect(event){
    console.log(event);
    this.selectionMessage = `No selection`
  }


}
