import { TestBed, async } from '@angular/core/testing';

import { AppComponent } from './app.component';

describe('AppComponent - Unit Tests', () => {
  it('should create the app', async(() => {
    const app = new AppComponent(null);
    expect(app).toBeTruthy();
  }));

  it(`should have as title 'app works!'`, async(() => {
    const app = new AppComponent(null);
    expect(app.title).toEqual('app works!');
  }));
});
