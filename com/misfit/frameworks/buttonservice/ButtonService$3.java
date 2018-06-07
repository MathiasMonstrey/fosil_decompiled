package com.misfit.frameworks.buttonservice;

class ButtonService$3 implements Runnable {
    final /* synthetic */ ButtonService this$0;
    final /* synthetic */ String val$serial;

    ButtonService$3(ButtonService buttonService, String str) {
        this.this$0 = buttonService;
        this.val$serial = str;
    }

    public void run() {
        ButtonService.access$600(this.this$0, this.val$serial);
    }
}
