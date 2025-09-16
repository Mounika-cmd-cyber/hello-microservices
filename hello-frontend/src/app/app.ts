import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Greeting } from './greeting';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  
  greeting: string = '';  

  constructor(private greetingService: Greeting) {}

  ngOnInit() {
    this.greetingService.getGreeting().subscribe(data => {
     // console.log("Backend says:", data);
      this.greeting = data;
    });
  }
}
