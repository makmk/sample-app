/* podTemplate(yaml: """
kind: Pod
spec:
  containers:
  - name: kaniko
    image: gcr.io/kaniko-project/executor:debug-v1.0.0
    imagePullPolicy: Always
    command:
    - /busybox/cat
    tty: true
    volumeMounts:
    - mountPath: "/kaniko/.docker"
      name: "volume-0"
      readOnly: false
    - mountPath: "/workspace"
      name: "build-workspace"
      readOnly: false
  volumes:
  - configMap:
      name: "docker-ecr-config"
      optional: false
    name: "volume-0"
  - emptyDir:
      medium: ""
    name: build-workspace
"""
) */
stage 'build'
node('kaniko') {
    def checkout = checkout scm
    container('kaniko') {
      sh "/kaniko/executor --dockerfile `pwd`/Dockerfile --context `pwd` --destination ${DOCKER_REGISTRY_URL}/makmk/sample-app:${checkout.GIT_BRANCH}-${checkout.GIT_COMMIT}"
    }
}
