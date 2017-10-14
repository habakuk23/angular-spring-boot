import {ErrorHandler, NgModule} from '@angular/core';
import {CoreModule} from 'core/core.module';
import {RouterModule} from '@angular/router';
import {AppErrorHandler} from 'root/app-error-handler';
import {AppComponent} from 'core/components/app/app.component';

@NgModule({
  imports: [
    CoreModule,
    RouterModule.forRoot([])
  ],
  providers: [
    {provide: ErrorHandler, useClass: AppErrorHandler},
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
