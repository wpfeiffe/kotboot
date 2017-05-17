import {Injectable} from '@angular/core';
import {Http, Response, URLSearchParams, BaseRequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {Department} from './department.model'; 

@Injectable()
export class DepartmentService {
  private departmentUrl: string = `http://${window.location.hostname}:8080/api/departments`;

  constructor(private http: Http) {
  }

  getDepartments(): Observable<Department[]> {
    return this.http.get(this.departmentUrl)
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