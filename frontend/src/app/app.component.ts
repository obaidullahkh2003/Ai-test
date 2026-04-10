import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <mat-toolbar color="primary">Computer Parts Store</mat-toolbar>
    <main style="padding: 16px">
      <h2>Products</h2>
      <p>Login, browse parts, add to cart, and checkout.</p>
      <button mat-raised-button color="accent">Go to Cart</button>
    </main>
  `
})
export class AppComponent {}
