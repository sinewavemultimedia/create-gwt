(function(window) {
	var TextLink = function(text, font, color, hoverColor) {
			this.initialize(text, font, color, hoverColor);
		}
		TextLink.prototype = new createjs.Text(); // extend Text.
		
		// save off initialize method from Text so we can call it from our own:
		TextLink.prototype.Text_initialize = TextLink.prototype.initialize;
		
		// overwrite Text's initialize method with our own:
		TextLink.prototype.initialize = function(text, font, color, hoverColor) {
			this.Text_initialize(text, font, color); 
			this.hoverColor = hoverColor;
			this.hover = false;
			this.hitArea = new createjs.Shape();
			this.textBaseline = "top";
		}
		
		// use the same approach with draw:
		TextLink.prototype.Text_draw = TextLink.prototype.draw;
		TextLink.prototype.draw = function(ctx, ignoreCache) {
			// save default color, and overwrite it with the hover color if appropriate:
			var color = this.color;
			if (this.hover) { this.color = this.hoverColor; }
			
			// call Text's drawing method to do the real work of drawing to the canvas:
			this.Text_draw(ctx, ignoreCache);
			
			// restore the default color value:
			this.color = color;
			
			// update hit area so the full text area is clickable, not just the characters:
			this.hitArea.graphics.clear().beginFill("#FFF").drawRect(0,0,this.lineWidth||this.getMeasuredWidth(), this.getMeasuredHeight());
		}
		
		// set up the handlers for mouseover / out:
		TextLink.prototype.onMouseOver = function() {
			this.hover = true;
		}
		TextLink.prototype.onMouseOut = function() {
			this.hover = false;
		}
		
	    window.TextLink = TextLink;
}(window));		