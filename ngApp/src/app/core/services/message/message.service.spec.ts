import { TestBed, inject } from '@angular/core/testing';

import { MessageService } from './message.service';
import {BaseRequestOptions, Http, HttpModule} from '@angular/http';
import {MockBackend} from '@angular/http/testing';

describe('MessageService - Integration Tests', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpModule],
      providers: [MessageService, MockBackend, BaseRequestOptions,
        {
          provide: Http,
          useFactory: (fakeBackendFactory: MockBackend, defaultOptions: BaseRequestOptions) => {
            return new Http(fakeBackendFactory, defaultOptions);
          }, deps: [MockBackend, BaseRequestOptions]
        }]
    });
  });

  it('should ...', inject([MessageService], (service: MessageService) => {
    expect(service).toBeTruthy();
  }));
});
