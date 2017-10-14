import { TestBed, inject } from '@angular/core/testing';
import {DataService, URL} from './data.service';
import {HttpModule} from '@angular/http';

describe('DataService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpModule],
      providers: [DataService,
        {provide: URL, useValue: ''}]
    });
  });

  it('should ...', inject([DataService], (service: DataService) => {
    expect(service).toBeTruthy();
  }));
});
