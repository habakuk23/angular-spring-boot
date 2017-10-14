import {Component, OnInit} from '@angular/core';
import {MessageService} from '../../services/message/message.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app works!';
  messages$;

  constructor(private service: MessageService) {
  }

  ngOnInit(): void {
    this.messages$ = this.service.getAll();
  }
}
