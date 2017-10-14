import {TestBed, async, ComponentFixture} from '@angular/core/testing';

import { AppComponent } from './app.component';
import {CoreModule} from 'core/core.module';
import {RouterTestingModule} from '@angular/router/testing';
import {Router} from '@angular/router';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/from';
import {MessageService} from 'core/services/message/message.service';


class RouterStub {
  navigate(params) {}
}

describe('AppComponent - Integration Tests', () => {
  let component: AppComponent;
  let service: MessageService;

  beforeEach(() => {
    service = new MessageService(null);
    component = new AppComponent(service);

    TestBed.configureTestingModule({
      imports: [
        CoreModule,
        RouterTestingModule.withRoutes([])
      ],
      providers: [
        { provide: Router, useClass: RouterStub },
      ]
    }).compileComponents();
  });


  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));

  it(`should have as title 'app works!'`, async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('app works!');
  }));

  it('should render title in a h1 tag', async(() => {

    // Arrange
    spyOn(service, 'getAll').and.callFake(() => {
      return Observable.from([[{author: 'a', content: 'b'}]]);
    });
    const fixture = TestBed.createComponent(AppComponent);

    // Act
    // fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;

    // debugger;

    // Assert
    console.log(compiled.querySelector('h1').textContent);
    // expect(compiled.querySelector('h1').textContent).toContain('app works!');
    // expect(component.title).toContain('app works');
  }));

  /*
  it('should list the messages from the service', async(() => {

    // Arrange
    const fixture = TestBed.createComponent(AppComponent);

    // Act
    spyOn(service, 'getAll').and.callFake(() => {
      return Observable.from([[{author: 'a', content: 'b'}]]);
    });
    fixture.detectChanges();

    const compiled = fixture.debugElement.nativeElement;

    // debugger;

    // Assert
    expect(compiled.querySelector('h1').textContent).toContain('app works!');
    // expect(component.title).toContain('app works');
  }));
  */
});
