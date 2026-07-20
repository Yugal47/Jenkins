{{- define "share-app.fullname" -}}
{{ .Release.Name }}
{{- end -}}

{{- define "share-app.labels" -}}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end -}}
