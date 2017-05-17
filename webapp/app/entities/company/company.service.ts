import {Injectable} from '@angular/core';
import {Http, Response, URLSearchParams, BaseRequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {Company} from './company.model';


@Injectable()
export class CompanyService {

  private companyUrl: string = `http://${window.location.hostname}:8080/api/companies`;

  constructor(private http: Http) {
  }

  getCompanies(): Observable<Company[]> {
    return this.http.get(this.companyUrl)
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
