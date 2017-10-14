import {Inject, Injectable, InjectionToken} from '@angular/core';
import {Http} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';

export const URL = new InjectionToken('URL');

@Injectable()
export class DataService {

  constructor(@Inject(URL) private url: string, private http?: Http) {
  }

  getAll() {
    return this.http.get(this.url)
      .map(response => response.json())
      .catch(this.handleError);
  }

  create(resource) {
    return this.http.post(this.url, JSON.stringify(resource))
      .map(response => response.json())
      .catch(this.handleError);
  }

  update(resource) {
    // return this.http.patch(`${this.url}/${resource.id}`, JSON.stringify({isRead: true}));
    return this.http.put(`${this.url}/${resource.id}`, JSON.stringify(resource))
      .map(response => response.json())
      .catch(this.handleError);
  }

  delete(resource) {
    return this.http.delete(`${this.url}/${resource.id}`)
      .map(response => response.json())
      .catch(this.handleError);
  }

  private handleError(error: Response) {
    if (error.status === 400) {
      return Observable.throw(error.json());
    }

    if (error.status === 404) {
      return Observable.throw(error.json());
    }
    return Observable.throw(error.json());
  }
}
