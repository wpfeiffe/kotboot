import {Injectable} from '@angular/core';
import {Http, Response, URLSearchParams, BaseRequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {Employee} from './employee.model';


@Injectable()
export class EmployeeService {

  private resourceUrl: string = `http://${window.location.hostname}:8080/api/employees`;

  constructor(private http: Http) {
  }

  getEmployees(): Observable<Employee[]> {
    return this.http.get(this.resourceUrl)
      .map(this.extractData)
      .catch(this.handleError);

  }

  create(employee: Employee): Observable<Employee> {
    const copy: Employee = Object.assign({}, employee);
    return this.http.post(this.resourceUrl, copy)
      .map(this.extractData)
      .catch(this.handleError);
  }

  update(employee: Employee): Observable<Employee> {
    const copy: Employee = Object.assign({}, employee);
    return this.http.put(this.resourceUrl, copy)
      .map(this.extractData)
      .catch(this.handleError);

  }

  get(id: string): Observable<Response> {
    var retval = this.http.get(`${this.resourceUrl}/${id}`)
      .map(this.extractData)
      .catch(this.handleError);

    return retval;
  }

  delete(id: number): Observable<Response> {
    return this.http.delete(`${this.resourceUrl}/${id}`)
      .map(this.extractData)
      .catch(this.handleError);
  }

  private extractData(res: Response)  {
    let body = res.json();
    return body || {};
  }

  private handleError(error: Response | any) {
    // In a real world app, you might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }

}
