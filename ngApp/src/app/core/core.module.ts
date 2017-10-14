import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AppComponent} from './components/app/app.component';
import {MessageService} from './services/message/message.service';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  declarations: [AppComponent],
  providers: [MessageService]
})
export class CoreModule {
}
