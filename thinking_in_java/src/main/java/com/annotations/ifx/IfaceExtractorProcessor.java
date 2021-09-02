// annotations/ifx/IfaceExtractorProcessor.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// javac-based annotation processing
package com.annotations.ifx;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.Elements;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// TODO: 2021/9/1 编译时处理器用于提取有趣的方法，
//  并创建一个新的interface源代码文件 （这个源代码文件会在下一轮中被自动编译）
@SupportedAnnotationTypes("annotations.ano.ifx.ExtractInterface")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class IfaceExtractorProcessor extends AbstractProcessor {

    private ArrayList<Element> interfaceMethods = new ArrayList<>();
    Elements elementUtils;
    private ProcessingEnvironment processingEnv;

    @Override
    public void init(ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;
        elementUtils = processingEnv.getElementUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
        for (Element elem : env.getElementsAnnotatedWith(ExtractInterface.class)) {
            String interfaceName = elem.getAnnotation(ExtractInterface.class).interfaceName();
            // TODO: 2021/9/1 getEncloseElements() 会通过指定的元素生成所有的“闭包”元素
            for (Element enclosed : elem.getEnclosedElements()) {
                // TODO: 2021/9/1 getKind() 获取所有 public 和 statis方法
                if (enclosed.getKind().equals(ElementKind.METHOD) &&
                        enclosed.getModifiers().contains(Modifier.PUBLIC) &&
                        !enclosed.getModifiers().contains(Modifier.STATIC)) {
                    interfaceMethods.add(enclosed);
                }
            }
            if (interfaceMethods.size() > 0) {
                writeInterfaceFile(interfaceName);
            }
        }
        return false;
    }

    private void writeInterfaceFile(String interfaceName) {
        try (
                Writer writer = processingEnv.getFiler()
                        .createSourceFile(interfaceName)
                        .openWriter()
        ) {
            String packageName = elementUtils.getPackageOf(interfaceMethods.get(0)).toString();

            writer.write("package " + packageName + ";\n");
            writer.write("public interface " + interfaceName + " {\n");

            for (Element elem : interfaceMethods) {
                // TODO: 2021/9/1 向下转型，获取所有的方法信息
                ExecutableElement method = (ExecutableElement) elem;
                String signature = "  public ";
                signature += method.getReturnType() + " ";
                signature += method.getSimpleName();
                signature += createArgList(method.getParameters());

                System.out.println(signature);
                writer.write(signature + ";\n");
            }
            writer.write("}");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成参数列表
     * @param parameters
     * @return
     */
    private String createArgList(List<? extends VariableElement> parameters) {
        String args = parameters.stream()
                .map(p -> p.asType() + " " + p.getSimpleName())
                .collect(Collectors.joining(", "));
        return "(" + args + ")";
    }
}
