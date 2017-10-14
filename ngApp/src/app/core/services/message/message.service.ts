import {Injectable, isDevMode} from '@angular/core';
import {Http} from '@angular/http';
import {DataService} from '../data.service';

@Injectable()
export class MessageService extends DataService {

  constructor(http: Http) {
    const url = isDevMode() ? 'http://localhost:8080/api/messages' : 'api/messages';
    super(url, http);
  }

}
