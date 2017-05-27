import {Injectable} from '@angular/core';
import {Http, Response, URLSearchParams, BaseRequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {Department} from './department.model'; 

@Injectable()
export class DepartmentService {
  private resourceUrl: string = `http://${window.location.hostname}:8080/api/departments`;

  constructor(private http: Http) {
  }

  getDepartments(): Observable<Department[]> {
    return this.http.get(this.resourceUrl)
      .map(this.extractData)
      .catch(this.handleError);

  }

  create(department: Department): Observable<Department> {
    const copy: Department = Object.assign({}, department);
    return this.http.post(this.resourceUrl, copy)
      .map(this.extractData)
      .catch(this.handleError);
  }

  update(department: Department): Observable<Department> {
    const copy: Department = Object.assign({}, department);
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