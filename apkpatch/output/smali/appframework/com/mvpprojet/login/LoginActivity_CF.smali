.class public Lappframework/com/mvpprojet/login/LoginActivity_CF;
.super Lappframework/com/mvpprojet/base/BaseAppCompatActivity;
.source "LoginActivity.java"

# interfaces
.implements Lappframework/com/mvpprojet/login/ILoginView;


# static fields
.field private static final ARG_PARAM1:Ljava/lang/String; = "param1"

.field private static final ARG_PARAM2:Ljava/lang/String; = "param2"


# instance fields
.field private button:Landroid/widget/Button;

.field private mParam1:Ljava/lang/String;

.field private mParam2:Ljava/lang/String;

.field private presenter:Lappframework/com/mvpprojet/login/LoginPresenter;

.field private pwd_edt:Landroid/widget/EditText;

.field private uid_edit:Landroid/widget/EditText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Lappframework/com/mvpprojet/base/BaseAppCompatActivity;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lappframework/com/mvpprojet/login/LoginActivity;)V
    .locals 0
    .param p0, "x0"    # Lappframework/com/mvpprojet/login/LoginActivity;

    .prologue
    .line 20
    invoke-direct {p0}, Lappframework/com/mvpprojet/login/LoginActivity_CF;->showMessage()V

    return-void
.end method

.method private showMessage()V
    .locals 5
    .annotation runtime Lcom/alipay/euler/andfix/annotation/MethodReplace;
        clazz = "appframework.com.mvpprojet.login.LoginActivity"
        method = "showMessage"
    .end annotation

    .prologue
    .line 53
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/temp/fix.apatch"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 57
    .local v1, "fixPath":Ljava/lang/String;
    :try_start_0
    sget-object v3, Lappframework/com/mvpprojet/base/BaseApplication;->patchManager:Lcom/alipay/euler/andfix/patch/PatchManager;

    invoke-virtual {v3, v1}, Lcom/alipay/euler/andfix/patch/PatchManager;->addPatch(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 62
    :goto_0
    const-string v2, "\u6253\u8865\u4e01\u4e4b\u540e"

    .line 63
    .local v2, "msg":Ljava/lang/String;
    const/4 v3, 0x0

    invoke-static {p0, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/Toast;->show()V

    .line 64
    return-void

    .line 58
    .end local v2    # "msg":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 59
    .local v0, "e":Ljava/io/IOException;
    const-string v3, "mvp_fix"

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method


# virtual methods
.method public getEditText(I)Landroid/view/View;
    .locals 1
    .param p1, "id"    # I

    .prologue
    .line 73
    invoke-virtual {p0, p1}, Lappframework/com/mvpprojet/login/LoginActivity_CF;->findViewById(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 88
    const v0, 0x7f040033

    return v0
.end method

.method public getLoginButton()Landroid/view/View;
    .locals 1

    .prologue
    .line 83
    const/4 v0, 0x0

    return-object v0
.end method

.method public hideProgress()V
    .locals 0

    .prologue
    .line 106
    return-void
.end method

.method public initView()V
    .locals 1

    .prologue
    .line 93
    const v0, 0x7f0c0095

    invoke-virtual {p0, v0}, Lappframework/com/mvpprojet/login/LoginActivity_CF;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lappframework/com/mvpprojet/login/LoginActivity_CF;->uid_edit:Landroid/widget/EditText;

    .line 94
    const v0, 0x7f0c0096

    invoke-virtual {p0, v0}, Lappframework/com/mvpprojet/login/LoginActivity_CF;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lappframework/com/mvpprojet/login/LoginActivity_CF;->pwd_edt:Landroid/widget/EditText;

    .line 95
    const v0, 0x7f0c0097

    invoke-virtual {p0, v0}, Lappframework/com/mvpprojet/login/LoginActivity_CF;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lappframework/com/mvpprojet/login/LoginActivity_CF;->button:Landroid/widget/Button;

    .line 96
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 36
    invoke-super {p0, p1}, Lappframework/com/mvpprojet/base/BaseAppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 37
    new-instance v0, Lappframework/com/mvpprojet/login/LoginPresenter;

    invoke-direct {v0, p0}, Lappframework/com/mvpprojet/login/LoginPresenter;-><init>(Lappframework/com/mvpprojet/login/ILoginView;)V

    iput-object v0, p0, Lappframework/com/mvpprojet/login/LoginActivity_CF;->presenter:Lappframework/com/mvpprojet/login/LoginPresenter;

    .line 38
    invoke-virtual {p0}, Lappframework/com/mvpprojet/login/LoginActivity_CF;->initView()V

    .line 43
    iget-object v0, p0, Lappframework/com/mvpprojet/login/LoginActivity_CF;->button:Landroid/widget/Button;

    new-instance v1, Lappframework/com/mvpprojet/login/LoginActivity$1;

    invoke-direct {v1, p0}, Lappframework/com/mvpprojet/login/LoginActivity$1;-><init>(Lappframework/com/mvpprojet/login/LoginActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 49
    return-void
.end method

.method public onLoginClick()V
    .locals 2

    .prologue
    .line 78
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lappframework/com/mvpprojet/view/HomeActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lappframework/com/mvpprojet/login/LoginActivity_CF;->startActivity(Landroid/content/Intent;)V

    .line 79
    return-void
.end method

.method public showProgress()V
    .locals 0

    .prologue
    .line 101
    return-void
.end method

.method public showToast(Ljava/lang/String;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 68
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 69
    return-void
.end method
