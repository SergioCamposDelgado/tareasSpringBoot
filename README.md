
# 🧠 Git Cheat Sheet + Chuleta Markdown

📘 **Chuleta Markdown para tu README:**  
https://profeinformatica101.github.io/git/Markdown

---

# 🚀 ¿`git fetch` o `git pull`? ¡No te confundas!

| Comando      | ¿Qué hace?                                           | ¿Afecta tu código local? |
|--------------|------------------------------------------------------|---------------------------|
| 🟢 `git fetch` | 🔎 Solo descarga los cambios remotos (sin mezclar)   | ❌ No                     |
| 🟠 `git pull`  | 🔄 Descarga y fusiona automáticamente los cambios    | ✅ Sí                     |

---

# 🧰 Comandos de Git Esenciales

Este repositorio sirve como guía rápida de los comandos más útiles de Git para el desarrollo y control de versiones.
## 🛠️ Configuración Inicial

1. **Configurar Usuario y Correo Electrónico**
   ```bash
   git config --global user.name "Tu Nombre"
   git config --global user.email "tuemail@example.com"
   ```

2. **Ver la Configuración Actual**
   ```bash
   git config --list
   ```

3. **Instalar Oh My Zsh (opcional, para mejorar tu experiencia en la terminal)**
   ```bash
   sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
   ```

---

## 📂 Gestión de Repositorios

### 1. Crear un Repositorio

- **Inicializar un Nuevo Repositorio**
  ```bash
  git init
  ```

### 2. Clonar un Repositorio Existente

- **Clonar un Repositorio**
  ```bash
  git clone [URL]
  ```

---

## ✏️ Gestión de Cambios

### 1. Ver el Estado

- **Verificar el Estado del Repositorio**
  ```bash
  git status
  ```

### 2. Preparar Archivos para un Commit

- **Agregar Archivos al Área de Staging**
  ```bash
  git add [archivo]
  git add .
  ```

- **Eliminar un Archivo del Área de Staging**
  ```bash
  git reset [archivo]
  ```

### 3. Registrar Cambios

- **Realizar un Commit**
  ```bash
  git commit -m "Mensaje del commit"
  ```

- **Modificar el Último Commit (sin cambiar el mensaje)**
  ```bash
  git commit --amend --no-edit
  ```

- **Modificar el Último Commit (cambiando el mensaje)**
  ```bash
  git commit --amend -m "Nuevo mensaje del commit"
  ```

---

## 🕒 Historial y Restauración

### 1. Ver el Historial

- **Ver Historial de Commits**
  ```bash
  git log --pretty=format:"%h - %an, %ar : %s"
  ```

### 2. Restaurar Cambios

- **Restaurar a un Commit Pasado**
  ```bash
  git reset --hard <id_commit>
  git push --force
  ```

- **Listar Commits en Orden Inverso**
  ```bash
  git log --reverse
  ```

- **Actualizar con Rebase para un Historial Lineal**
  ```bash
  git pull origin main --rebase
  ```

---

## 🌱 Trabajo con Ramas

### 1. Gestión de Ramas

- **Listar Ramas**
  ```bash
  git branch -a
  ```

- **Crear una Nueva Rama**
  ```bash
  git branch [nombre-rama]
  ```

- **Cambiar de Rama**
  ```bash
  git checkout [nombre-rama]
  ```

### 2. Fusionar Ramas

- **Fusionar Cambios**
  ```bash
  git merge [nombre-rama]
  ```

- **Resolver Conflictos de Fusión**
  ```bash
  git mergetool
  ```

---

## 🌐 Repositorios Remotos

### 1. Sincronización

- **Subir Cambios**
  ```bash
  git push [alias] [rama]
  ```

- **Subir Cambios Forzados (con Precaución)**
  ```bash
  git push origin [rama] --force
  ```

- **Actualizar desde el Repositorio Remoto**
  ```bash
  git pull [alias] [rama]
  ```

- **Traer Cambios sin Integrar Automáticamente**
  ```bash
  git fetch [alias]
  ```

### 2. Configuración de Repositorio Remoto

- **Cambiar la URL**
  ```bash
  git remote set-url origin git@github.com:[tu_usuario]/[tu_repositorio].git
  ```

- **Añadir un Nuevo Repositorio**
  ```bash
  git remote add origin git@github.com:[tu_usuario]/[tu_repositorio].git
  ```

---

## 🔒 Claves SSH

1. **Generar una Nueva Clave**
   ```bash
   ssh-keygen -t rsa -b 4096 -C "tu_email@example.com"
   ```

2. **Agregar Clave al ssh-agent**
   ```bash
   eval "$(ssh-agent -s)"
   ssh-add ~/.ssh/tu_clave_privada
   ```

---

## 🛠️ Utilidades Adicionales

1. **Comprobar Conexión Remota**
   ```bash
   ssh -T git@github.com
   ```

2. **Comparar Cambios**
   ```bash
   git diff [branch1]..[branch2]
   ```

3. **Reestablecer Archivos**
   ```bash
   git reset [archivo]
   ```

4. **Alias Útil**
   - **Crear un Alias para 'git tree'**
     ```bash
     git config --global alias.tree "log --graph --decorate --all --oneline"
     ```

---

## 💡 Comandos Avanzados y Prácticas Recomendadas

1. **Eliminar Ramas Locales**
   ```bash
   git branch -d [nombre-rama]
   ```

2. **Eliminar Ramas Remotas**
   ```bash
   git push origin --delete [nombre-rama]
   ```

3. **Ver Cambios entre Commits**
   ```bash
   git diff [id_commit1] [id_commit2]
   ```

4. **Stash de Cambios Temporales**
   ```bash
   git stash
   git stash pop
   ```

5. **Mostrar Ramas que Contienen un Commit Específico**
   ```bash
   git branch --contains [id_commit]
   ```

---

## 💡 Verifica tus remotos actuales

```bash
   git remote -v
```

# Ejemplo de traerse una rama de un repositorio que se ha realizado anteriormente Fork

## Agrega el repositorio original como remoto `upstream`

```bash
   git remote add upstream https://github.com/profeInformatica101/tienda.git
```

## Trae las ramas del repositorio original (`upstream`)

```bash
   git fetch upstream
```

## Crea tu propia rama basada en `feature/sin-pruebas`

```bash
   git checkout -b mi-feature upstream/feature/sin-pruebas
```

## Sube los cambios a tu repositorio

```bash
   git push origin mi-feature
```

## Gestiona los cambios en tu repositorio

```bash
   git add .
   git commit -m "Descripción de los cambios"
   git push origin mi-feature
```

## Actualizar tu rama con los cambios de `upstream`

```bash
   git fetch upstream
   git merge upstream/feature/sin-pruebas
```
