from tkinter import *

class MoveBall:

    def __init__(self, app):
        self.canvas = Canvas(app, width=400, height=300)
        self.canvas.pack()
        self.app = app
        self.deltax = 20
        self.deltay = 20
        self.canvas.create_oval(100, 150, 150, 200, fill='red', tag='redBall')
        self.canvas.pack()
    def fn_move_left(self, event):
        self.canvas.move('redBall', -self.deltax, 0)
        self.canvas.after(2)
        self.canvas.update()
    def fn_move_right(self, event):
        self.canvas.move('redBall', self.deltax, 0)
        self.canvas.after(2)
        self.canvas.update()

    def fn_move_up(self, event):
        self.canvas.move('redBall', 0, -self.deltay)
        self.canvas.after(2)
        self.canvas.update()

    def fn_move_down(self, event):
        self.canvas.move('redBall', 0, self.deltay)
        self.canvas.after(2)
        self.canvas.update()
app = Tk()
mov = MoveBall(app)
mov.canvas.bind('<Left>', mov.fn_move_left)
mov.canvas.bind('<Right>', mov.fn_move_right)
mov.canvas.bind('<Up>', mov.fn_move_up)
mov.canvas.bind('<Down>', mov.fn_move_down)
mov.canvas.focus_set()
mov.canvas.pack()
app.mainloop()